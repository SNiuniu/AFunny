package com.sniuniu.afunny.widget.home;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sniuniu.afunny.DataList;
import com.sniuniu.afunny.R;

import java.io.IOException;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter {
    private static final String TAG = "VideoAdapter";

    List<DataList.DataBean> mDatas;
    MediaPlayer mMediaPlayer;
    private int mCurrPosition;
    private SurfaceHolder.Callback callback;

    public VideoAdapter(List<DataList.DataBean> datas) {
        super();
        this.mDatas = datas;
        mMediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video_layout, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");
        VideoViewHolder videoViewHolder = (VideoViewHolder) viewHolder;
        final DataList.DataBean dataBean = mDatas.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerInside().placeholder(R.mipmap.icon_default_header);
        Glide.with(viewHolder.itemView.getContext())
                .load(dataBean.getHeader())
                .apply(requestOptions)
                .into(videoViewHolder.headerIv);

        videoViewHolder.headerTv.setText(dataBean.getUsername());
        videoViewHolder.descriptionTv.setText(dataBean.getText());
//        videoViewHolder.playCountTv.setText(dataBean.getUp());
        videoViewHolder.playDurationTv.setText(dataBean.getPasstime());
        videoViewHolder.upvoteTv.setText(String.valueOf(dataBean.getUp()));
        videoViewHolder.downvoteTv.setText(String.valueOf(dataBean.getDown()));
        videoViewHolder.commentTv.setText(String.valueOf(dataBean.getComment()));
        videoViewHolder.forwordTv.setText(String.valueOf(dataBean.getForward()));

        videoViewHolder.playStatusIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrPosition = position;
                notifyItemChanged(mCurrPosition);
            }
        });


        if (mCurrPosition == position) {
            SurfaceHolder holder = videoViewHolder.videoSv.getHolder();
            holder.setKeepScreenOn(true);
            callback = new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Log.d(TAG, "surfaceCreated: width * height = " + mMediaPlayer.getVideoWidth()+" * "+ mMediaPlayer.getVideoHeight());
                    mMediaPlayer.reset();
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mMediaPlayer.setDisplay(surfaceHolder);
                    try {
                        mMediaPlayer.setDataSource(dataBean.getVideo());
                        mMediaPlayer.prepareAsync();
                        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mMediaPlayer.start();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

                }
            };
            holder.addCallback(callback);

        }
    }

    @Override
    public int getItemCount() {
        if (null == mDatas) {
            return 0;
        }
        return mDatas.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView headerIv;
        private final TextView headerTv;
        private final TextView descriptionTv;
        private final ImageView playStatusIv;
        private final TextView forwordTv;
        private final TextView commentTv;
        private final TextView downvoteTv;
        private final TextView upvoteTv;
        private final TextView playDurationTv;
        private final TextView playCountTv;
        private final SurfaceView videoSv;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            headerIv = itemView.findViewById(R.id.header_image_view);
            headerTv = itemView.findViewById(R.id.header_text_view);
            descriptionTv = itemView.findViewById(R.id.description_text_view);
            videoSv = itemView.findViewById(R.id.content_surface_view);
            playStatusIv = itemView.findViewById(R.id.play_or_pause_icon_image_view);
            playCountTv = itemView.findViewById(R.id.play_count_text_view);
            playDurationTv = itemView.findViewById(R.id.play_duration_text_view);
            upvoteTv = itemView.findViewById(R.id.upvote_text_view);
            downvoteTv = itemView.findViewById(R.id.downvote_text_view);
            commentTv = itemView.findViewById(R.id.comment_text_view);
            forwordTv = itemView.findViewById(R.id.forward_text_view);
        }
    }
}
