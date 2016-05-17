package pub.iyu.qr;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

public class ResultActivity extends Activity {

	private TextView tv;
	private ImageView img;
	private Button btn;
	private Button btnintent;
	private Bundle bundle;
	private WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		initView();

		initdata();

	}

	private void initdata() {
		Intent intentvalue = getIntent();
		bundle = intentvalue.getExtras();
		tv.setText(bundle.getString("result"));
		img.setImageBitmap((Bitmap)intentvalue.getParcelableExtra("bitmap"));
		btnintent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = bundle.getString("result");
				String substr = str.substring(0, 4);
				if(substr.equals("http")){

					web = new WebView(ResultActivity.this);

					web.getSettings().setJavaScriptEnabled(true);//设置支持脚本
					web.getSettings().setBuiltInZoomControls(true);// 设置支持缩放

					web.loadUrl(str);

					Toast.makeText(ResultActivity.this, "即将打开网址："+str, Toast.LENGTH_SHORT).show();
					Toast.makeText(ResultActivity.this, "网址打开成功!", Toast.LENGTH_SHORT).show();

					setContentView(web);

//					web.setWebViewClient(new WebViewClient() {
//
//						public boolean shouldOverrideUrlLoading(WebView view, String str){
//							//  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
//							view = new WebView(ResultActivity.this);
//							view.loadUrl(str);
//							Toast.makeText(ResultActivity.this, "即将打开网址："+str, Toast.LENGTH_SHORT).show();
//							Toast.makeText(ResultActivity.this, "网址打开成功!", Toast.LENGTH_SHORT).show();
//							setContentView(view);
//							return true;
//						}
//
//						@Override
//						public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//							handler.proceed();
//						}
//					});

				}else{
					Toast.makeText(ResultActivity.this, "这不是网址！", Toast.LENGTH_SHORT).show();
				}
			}
		});

		/*
		 * 点击关闭当前页面
		 * */
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ResultActivity.this.finish();
			}
		});
	}

	private void initView() {
		tv = (TextView) findViewById(R.id.result_name);
		img = (ImageView) findViewById(R.id.result_bitmap);
		btn = (Button) findViewById(R.id.button_back);
		btnintent = (Button) findViewById(R.id.intent2view);
	}

//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
//			web.goBack();
//			return true;
//		}
//		return false;
//		
//	}


}
