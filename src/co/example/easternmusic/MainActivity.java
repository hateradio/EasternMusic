package co.example.easternmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
	private Button btnBamboo, btnPalace;

	private MediaPlayer mpBamboo, mpPalace;
	
	private Boolean playing = false;
	
	int play = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setBtnBamboo((Button) findViewById(R.id.btnBamboo));
		setBtnPalace((Button) findViewById(R.id.btnPalace));
		btnBamboo.setOnClickListener(lBamboo);
		btnPalace.setOnClickListener(lPalace);
		
		setMpBamboo(MediaPlayer.create(this, R.raw.bamboo));
		mpPalace = MediaPlayer.create(this, R.raw.palace);
		
	}
	
	Button.OnClickListener lBamboo = new Button.OnClickListener ()
	{
		@Override
		public void onClick(View v) {
			if (play == 1) {
				getMpBamboo().pause();
				getBtnBamboo().setText("Start Bamboo Song");
				getBtnPalace().setVisibility(View.VISIBLE);
				play = 0;
			} else {
				getMpBamboo().start();
				getBtnBamboo().setText("Pause Bamboo Song");
				getBtnPalace().setVisibility(View.INVISIBLE);
				play = 1;
			}
			setPlaying(!getPlaying());
		}
	};

	Button.OnClickListener lPalace = new Button.OnClickListener ()
	{
		@Override
		public void onClick(View v) {
			if (getPlaying()) {
				getMpPalace().pause();
				getBtnPalace().setText("Start Palace Song");
				getBtnBamboo().setVisibility(View.VISIBLE);
			} else {
				getMpPalace().start();
				getBtnPalace().setText("Pause Palace Song");
				getBtnBamboo().setVisibility(View.INVISIBLE);
			}
			setPlaying(!getPlaying());
		}
	};

	public Button getBtnBamboo() {
		return btnBamboo;
	}

	public void setBtnBamboo(Button btnBamboo) {
		this.btnBamboo = btnBamboo;
	}

	public Button getBtnPalace() {
		return btnPalace;
	}

	public void setBtnPalace(Button btnPalace) {
		this.btnPalace = btnPalace;
	}

	public MediaPlayer getMpBamboo() {
		return mpBamboo;
	}

	public void setMpBamboo(MediaPlayer mpBamboo) {
		this.mpBamboo = mpBamboo;
	}

	public MediaPlayer getMpPalace() {
		return mpPalace;
	}

	public void setMpPalace(MediaPlayer mpPalace) {
		this.mpPalace = mpPalace;
	}

	public Boolean getPlaying() {
		return playing;
	}

	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}
}
