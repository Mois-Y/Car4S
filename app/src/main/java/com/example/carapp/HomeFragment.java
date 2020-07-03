package com.example.carapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.Main_lunbo.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 知道碎片界面
 * @author wwj_748
 *
 */
public class HomeFragment extends Fragment {
//	轮播
	Banner banner;
	/*左右滑动卡片*/
	List<CityItem> cityList;
	RelativeLayout itmel;
	GridView gridView;

	/*卡片图*/
	int[] image={R.mipmap.b1,R.mipmap.b2,R.mipmap.b3,R.mipmap.b1};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab1_fragment, container,
				false);
		banner = (Banner) view.findViewById(R.id.banner);

		//轮播，网页图片
		String[] urls = getResources().getStringArray(R.array.url4);
		List list = Arrays.asList(urls);

		//List arrayList = new ArrayList(list);
		//本地图片数据（资源文件）
        /*List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        list.add(R.mipmap.a);*/
		banner.setImages(list)
				.setImageLoader(new GlideImageLoader())
				.start();

		/*卡片滑动*/
		@SuppressLint("WrongConstant")
		LayoutInflater layoutInflater = (LayoutInflater) this
				.getActivity().getSystemService("layout_inflater");
		gridView = (GridView) view.findViewById(R.id.grid);
		setData();
		setGridView();
		return view;
	}
	/*卡片滑动*/
	/**设置数据*/
	private void setData() {
		cityList = new ArrayList<CityItem>();
		CityItem item = new CityItem();
		item.setImageView(image[0]);
		item.setCityName("车型");
		item.setCityCode("价格");
		cityList.add(item);
		item = new CityItem();
		item.setImageView(image[1]);
		item.setCityName("广州");
		item.setCityCode("020");
		cityList.add(item);
		item = new CityItem();
		item.setImageView(image[2]);
		item.setCityName("北京");
		item.setCityCode("010");
		cityList.add(item);
		item = new CityItem();
		item.setImageView(image[3]);
		item.setCityName("武汉");
		item.setCityCode("027");
		cityList.add(item);
		//cityList.addAll(cityList);
	}

	/**设置GirdView参数，绑定数据*/
	private void setGridView() {
		int size = cityList.size();
		int length = 100;
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		float density = dm.density;
		int gridviewWidth = (int) (size * (length + 4) * density);
		int itemWidth = (int) (length * density);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
		gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
		gridView.setColumnWidth(itemWidth); // 设置列表项宽
		gridView.setHorizontalSpacing(5); // 设置列表项水平间距
		gridView.setStretchMode(GridView.NO_STRETCH);
		gridView.setNumColumns(size); // 设置列数量=列表集合数

		GridViewAdapter adapter = new GridViewAdapter(getActivity().getApplicationContext(),
				cityList);
		gridView.setAdapter(adapter);
	}

	/**GirdView 数据适配器*/
	public class GridViewAdapter extends BaseAdapter {
		Context context;
		List<CityItem> list;
		public GridViewAdapter(Context _context, List<CityItem> _list) {
			this.list = _list;
			this.context = _context;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater layoutInflater = LayoutInflater.from(context);
			convertView = layoutInflater.inflate(R.layout.list_item_tab1, null);
			TextView tvCity = (TextView) convertView.findViewById(R.id.tvCity);
			TextView tvCode = (TextView) convertView.findViewById(R.id.tvCode);
			ImageView imageView = (ImageView) convertView.findViewById(R.id.ItemImage) ;
			CityItem city = list.get(position);
			tvCity.setText(city.getCityName());
			tvCode.setText(city.getCityCode());
			imageView.setImageResource(city.getImageView());
			return convertView;
		}
	}

	public class CityItem {
		private int imageView;
		private String cityName;
		private String cityCode;

		public int getImageView() {
			return imageView;
		}

		public void setImageView(int imageView) {
			this.imageView = imageView;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getCityCode() {
			return cityCode;
		}

		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
}
