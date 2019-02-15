package com.voyager.barasti.activity.calenderactivity.adapter;


import com.voyager.barasti.custom.Calender_libary.caldroid.CaldroidFragment;
import com.voyager.barasti.custom.Calender_libary.caldroid.CaldroidGridAdapter;

public class CaldroidSampleCustomFragment extends CaldroidFragment {

	@Override
	public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {
		// TODO Auto-generated method stub
		return new CaldroidSampleCustomAdapter(getActivity(), month, year,
				getCaldroidData(), extraData);
	}

}
