package com.example.android.musilicious;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.musilicious.databinding.ActivityPlayingBinding;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Song> songList;
    private int position;
    private ActivityPlayingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_playing);

        //To get the extras from previous activity
        Intent intent = getIntent();
        if (intent.hasExtra("LIST")) {
            songList = (ArrayList<Song>) intent.getSerializableExtra("LIST");
            position = intent.getIntExtra("POSITION", 0);
        }

        //Setting up views with the clicked song/album
        binding.setSong(songList.get(position));

        //Setting OnClickListerner to all clickable imageviews
        binding.back.setOnClickListener(this);
        binding.menu.setOnClickListener(this);
        binding.repeat.setOnClickListener(this);
        binding.previous.setOnClickListener(this);
        binding.play.setOnClickListener(this);
        binding.next.setOnClickListener(this);
        binding.shuffle.setOnClickListener(this);
        binding.home.setOnClickListener(this);
        binding.favorite.setOnClickListener(this);
        binding.playlist.setOnClickListener(this);

        new AlertDialog.Builder(this)
                .setCancelable(true)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setTitle(R.string.play_title)
                .setMessage(getString(R.string.play_desc))
                .show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.menu:
                Toast.makeText(getApplicationContext(), getString(R.string.menu), Toast.LENGTH_SHORT).show();
                break;
            case R.id.repeat:
                Toast.makeText(getApplicationContext(), getString(R.string.repeat), Toast.LENGTH_SHORT).show();
                break;
            case R.id.previous:
                if (position == 0) {
                    position = songList.size() - 1;
                } else position--;
                binding.setSong(songList.get(position));
                break;
            case R.id.play:
                Toast.makeText(getApplicationContext(), getString(R.string.play), Toast.LENGTH_SHORT).show();
                break;
            case R.id.next:
                if (position == songList.size() - 1) {
                    position = 0;
                } else position++;
                binding.setSong(songList.get(position));
                break;
            case R.id.shuffle:
                Toast.makeText(getApplicationContext(), getString(R.string.shuffle), Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                finish();
                break;
            case R.id.favorite:
                Toast.makeText(getApplicationContext(), getString(R.string.favorite), Toast.LENGTH_SHORT).show();
                break;
            case R.id.playlist:
                Toast.makeText(getApplicationContext(), getString(R.string.playlist), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
