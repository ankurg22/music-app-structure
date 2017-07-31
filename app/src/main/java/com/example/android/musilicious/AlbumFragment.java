package com.example.android.musilicious;


import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.musilicious.databinding.AlbumGridItemBinding;
import com.example.android.musilicious.databinding.FragmentSongBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class AlbumFragment extends Fragment {
    private ArrayList<Song> albumList = new ArrayList<>();


    public AlbumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSongBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_song, container, false);

        getSongs();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        AlbumAdapter adapter = new AlbumAdapter();

        binding.songRecyclerView.setLayoutManager(gridLayoutManager);
        binding.songRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    //Adapter class for RecyclerView
    private class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {

        @Override
        public AlbumAdapter.AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            AlbumGridItemBinding itemBinding = AlbumGridItemBinding.inflate(layoutInflater, parent, false);
            return new AlbumHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(AlbumHolder holder, int position) {
            Song song = albumList.get(position);
            holder.bind(song);
        }

        @Override
        public int getItemCount() {
            return albumList.size();
        }

        public class AlbumHolder extends RecyclerView.ViewHolder {
            private AlbumGridItemBinding binding;

            public AlbumHolder(AlbumGridItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void bind(Song song) {
                binding.setSong(song);
                binding.executePendingBindings();
                binding.albumImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), PlayingActivity.class);
                        intent.putExtra("LIST", albumList);
                        intent.putExtra("POSITION", getAdapterPosition());
                        startActivity(intent);
                    }
                });
            }
        }
    }

    /**
     * Since Data Binding library was not able to load drawables so I Google'd and found solution
     *https://stackoverflow.com/a/35809319/6494628
     */
    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }

    private void getSongs() {
        Song[] songs = new Song[14];
        songs[0] = new Song(1, "Alone", "Alan Walker", "Alone", R.drawable.alone);
        songs[1] = new Song(2, "Don't Let Me Down", "The Chainsmokers", "Collage", R.drawable.dont_let_me_down);
        songs[2] = new Song(3, "Faded", "Alan Walker", "Faded", R.drawable.faded);
        songs[3] = new Song(4, "Hymn For The Weekend", "Coldplay", "A Head Full Of Dreams", R.drawable.hymn_weekend);
        songs[4] = new Song(5, "I Got You", "Bebe Rexha", "All Your Fault", R.drawable.i_got_you);
        songs[5] = new Song(6, "It Ain't Me", "Kygo & Selena Gomez", "It Ain't Me", R.drawable.it_aint_me);
        songs[6] = new Song(7, "Never Forget You", "Zara Larsson", "So Good", R.drawable.never_forget_you);
        songs[7] = new Song(8, "One Dance", "Drake", "Views", R.drawable.one_dance);
        songs[8] = new Song(9, "Pillowtalk", "Zayn Malik", "Mind Of Mine", R.drawable.pillowtalk);
        songs[9] = new Song(10, "Rockabye", "Clean Bandit", "Rockabye", R.drawable.rockabye);
        songs[10] = new Song(11, "Something Just Like This", "The Chainsmokers & Coldplay", "Memories...Do Not Open", R.drawable.something_just_like_this);
        songs[11] = new Song(12, "Stitches", "Shawn Mendes", "Handwritten", R.drawable.stitches);
        songs[12] = new Song(13, "Symphony", "Clean Bandit", "Symphony", R.drawable.symphony);
        songs[13] = new Song(14, "What's My Name", "Rih anna", "Loud", R.drawable.whats_my_name);

        albumList.addAll(Arrays.asList(songs));
    }

}
