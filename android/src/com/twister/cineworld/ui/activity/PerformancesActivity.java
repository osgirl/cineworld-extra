package com.twister.cineworld.ui.activity;

import java.util.List;

import android.view.ContextMenu;
import android.widget.ListAdapter;

import com.twister.cineworld.R;
import com.twister.cineworld.model.json.CineworldAccessor;
import com.twister.cineworld.model.json.data.CineworldPerformance;
import com.twister.cineworld.ui.adapter.PeformanceAdapter;

public class PerformancesActivity extends BaseListActivity<CineworldPerformance, CineworldPerformance> {
	public PerformancesActivity() {
		super(R.layout.activity_performances, R.menu.context_item_performance);
	}

	@Override
	protected void onCreateContextMenu(final ContextMenu menu, final CineworldPerformance item) {
		menu.setHeaderTitle(item.getTime());
	}

	public List<CineworldPerformance> retrieve() {
		return new CineworldAccessor().getPeformances("66", "62278", "20130427");
	}

	public List<CineworldPerformance> process(final List<CineworldPerformance> list) {
		return list;
	}

	@Override
	protected ListAdapter createAdapter(final List<CineworldPerformance> result) {
		return new PeformanceAdapter(PerformancesActivity.this, result);
	}
}