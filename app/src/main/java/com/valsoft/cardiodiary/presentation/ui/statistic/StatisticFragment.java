package com.valsoft.cardiodiary.presentation.ui.statistic;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.domain.model.DailyIndexesItem;
import com.valsoft.cardiodiary.domain.model.PressureItem;
import com.valsoft.cardiodiary.domain.model.StatisticItem;
import com.valsoft.cardiodiary.domain.model.SymptomsItem;
import com.valsoft.cardiodiary.presentation.viewmodel.statistic.StatisticViewModel;

import java.util.ArrayList;
import java.util.List;

public class StatisticFragment extends Fragment{

    private LineChart pressureChart, dailyChart;
    private ScatterChart mScatterChart;
    private List<Entry> diastolic, systolic, frequency, yFeelings, yActivity,
            yMood, yAnxiety, yIrritation, yConcentration, yFatigue, yPsychoemotionalStress, ySleep
            , heartPain, heartInterruptions, palpitation, headache, dizziness, dyspnea
            , lossOfConsciousness, edema;

    private LineData lineDataPressure, lineDataDaily, lineDataSymptoms;

    private StatisticViewModel mViewModel;
    private List<PressureItem> mPressureItems;
    private List<DailyIndexesItem> mDailyIndexesItems;
    private List<SymptomsItem> mSymptomsItems;
    public void setArguments(long id){
        Bundle args = new Bundle();
        args.putLong("id", id);
        this.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StatisticViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        ((StatisticContainerActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((StatisticContainerActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        diastolic = new ArrayList<>();
        systolic = new ArrayList<>();
        frequency = new ArrayList<>();
        yFeelings = new ArrayList<>();
        yActivity = new ArrayList<>();
        yMood = new ArrayList<>();
        yAnxiety = new ArrayList<>();
        yIrritation = new ArrayList<>();
        yConcentration = new ArrayList<>();
        yFatigue = new ArrayList<>();
        yPsychoemotionalStress = new ArrayList<>();
        ySleep = new ArrayList<>();
        heartPain = new ArrayList<>();
        heartInterruptions = new ArrayList<>();
        palpitation = new ArrayList<>();
        headache = new ArrayList<>();
        dyspnea = new ArrayList<>();
        dizziness = new ArrayList<>();
        lossOfConsciousness = new ArrayList<>();
        edema = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pressureChart = view.findViewById(R.id.pressureChart);
        dailyChart = view.findViewById(R.id.dailyIndexesChart);
        mScatterChart = view.findViewById(R.id.symptomsChart);
        pressureChart.setDrawGridBackground(false);
        dailyChart.setDrawGridBackground(false);
        mScatterChart.setDrawGridBackground(false);

        pressureChart.getDescription().setEnabled(false);
        dailyChart.getDescription().setEnabled(false);
        mScatterChart.getDescription().setEnabled(false);

        pressureChart.getAxisRight().setDrawAxisLine(false);
        dailyChart.getAxisRight().setDrawAxisLine(false);
        mScatterChart.getAxisRight().setDrawAxisLine(false);

        pressureChart.getXAxis().setDrawGridLines(false);
        dailyChart.getXAxis().setDrawGridLines(false);
        mScatterChart.getXAxis().setDrawGridLines(false);

        pressureChart.setTouchEnabled(true);
        dailyChart.setTouchEnabled(true);
        mScatterChart.setTouchEnabled(true);

        pressureChart.setDragEnabled(true);
        dailyChart.setDragEnabled(true);
        mScatterChart.setDragEnabled(true);

        pressureChart.setScaleEnabled(true);
        dailyChart.setScaleEnabled(true);
        mScatterChart.setScaleEnabled(true);

        pressureChart.setPinchZoom(false);
        dailyChart.setPinchZoom(false);
        mScatterChart.setPinchZoom(false);

        Legend l = dailyChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);

        Legend ll = mScatterChart.getLegend();
        ll.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        ll.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        ll.setOrientation(Legend.LegendOrientation.VERTICAL);
        ll.setDrawInside(false);


        mViewModel.getLiveData().observe(this, this::setData);
        mViewModel.getStatisticItem(getArguments().getLong("id"));


    }

    private void setData(StatisticItem statisticItem){
        mPressureItems = statisticItem.getPressureItems();
        List<ILineDataSet> dataSetsPressures = new ArrayList<>();
        for (PressureItem item:mPressureItems) {
            diastolic.add(new Entry(item.getxDay(), item.getY1()));
            systolic.add(new Entry(item.getxDay(), item.getY2()));
            frequency.add(new Entry(item.getxDay(), item.getY3()));
        }


        dataSetsPressures.add(getDataSet(diastolic, "Діастолічний", Color.GREEN));
        dataSetsPressures.add(getDataSet(systolic, "Систолічний", Color.BLUE));
        dataSetsPressures.add(getDataSet(frequency, "ЧСС", Color.RED));
        lineDataPressure = new LineData(dataSetsPressures);
        lineDataPressure.setHighlightEnabled(false);
        pressureChart.setData(lineDataPressure);
        XAxis xAxis1 = pressureChart.getXAxis();
        xAxis1.setGranularity(1f);
        pressureChart.invalidate();

        mDailyIndexesItems = statisticItem.getDailyIndexesItems();
        List<ILineDataSet> dataSetsDaily = new ArrayList<>();
        for (DailyIndexesItem item:mDailyIndexesItems){
            yFeelings.add(new Entry(item.getxDay(), item.getyFeelings()));
            yActivity.add(new Entry(item.getxDay(), item.getyActivity()));
            yMood.add(new Entry(item.getxDay(), item.getyMood()));
            yAnxiety.add(new Entry(item.getxDay(), item.getyAnxiety()));
            yIrritation.add(new Entry(item.getxDay(), item.getyIrritation()));
            yConcentration.add(new Entry(item.getxDay(), item.getyIoncentration()));
            yFatigue.add(new Entry(item.getxDay(), item.getyFatigue()));
            yPsychoemotionalStress.add(new Entry(item.getxDay(), item.getyPsychoemotionalStress()));
            ySleep.add(new Entry(item.getxDay(), item.getySleep()));
        }

        dataSetsDaily.add(getDataSet(yFeelings, "Самопочуття", Color.RED));
        dataSetsDaily.add(getDataSet(yActivity, "Активність", Color.BLACK));
        dataSetsDaily.add(getDataSet(yMood, "Настрій", Color.BLUE));
        dataSetsDaily.add(getDataSet(yAnxiety, "Тривожність", Color.YELLOW));
        dataSetsDaily.add(getDataSet(yIrritation, "Роздратування", Color.GREEN));
        dataSetsDaily.add(getDataSet(yConcentration, "Концентрація", Color.GRAY));
        dataSetsDaily.add(getDataSet(yFatigue, "Втома", ColorTemplate.VORDIPLOM_COLORS[0]));
        dataSetsDaily.add(getDataSet(yPsychoemotionalStress, "Пс. напруження", ColorTemplate.VORDIPLOM_COLORS[1]));
        dataSetsDaily.add(getDataSet(ySleep, "Сон",  ColorTemplate.VORDIPLOM_COLORS[2]));
        lineDataDaily = new LineData(dataSetsDaily);
        lineDataDaily.setHighlightEnabled(false);
        dailyChart.setData(lineDataDaily);

        XAxis xAxis2 = dailyChart.getXAxis();
        xAxis2.setGranularity(1f);
        dailyChart.invalidate();

        mSymptomsItems = statisticItem.getSymptomsItems();
        ArrayList<IScatterDataSet> scatterDataSets = new ArrayList<>();
        for (SymptomsItem item:mSymptomsItems) {
            Log.d("Heart pain", String.valueOf(item.getHeartPain()));
            if (item.getHeartPain())heartPain.add(new Entry(item.getxDay(), 1));
            if (item.getHeartInterruptions())heartInterruptions.add(new Entry(item.getxDay(), 2));
            if (item.getPalpitation())palpitation.add(new Entry(item.getxDay(), 3));
            if (item.getHeadache())headache.add(new Entry(item.getxDay(), 4));
            if (item.isDyspnea())dyspnea.add(new Entry(item.getxDay(), 5));
            if (item.getDizziness())dizziness.add(new Entry(item.getxDay(), 6));
            if (item.getLossOfConsciousness())lossOfConsciousness.add(new Entry(item.getxDay(), 7));
            if (item.getEdema())edema.add(new Entry(item.getxDay(), 8));
        }
        scatterDataSets.add(getScatterDataSet(heartPain, "Біль в серці", Color.RED));
        scatterDataSets.add(getScatterDataSet(heartInterruptions, "Перебої", Color.BLACK));
        scatterDataSets.add(getScatterDataSet(palpitation, "Серцебиття", Color.BLUE));
        scatterDataSets.add(getScatterDataSet(headache, "Головний біль", Color.YELLOW));
        scatterDataSets.add(getScatterDataSet(dyspnea, "Задишка", Color.GREEN));
        scatterDataSets.add(getScatterDataSet(dizziness, "Запаморочення", ColorTemplate.VORDIPLOM_COLORS[0]));
        scatterDataSets.add(getScatterDataSet(lossOfConsciousness, "Втр. свідомості", ColorTemplate.VORDIPLOM_COLORS[1]));
        scatterDataSets.add(getScatterDataSet(edema, "Набряки", ColorTemplate.VORDIPLOM_COLORS[2]));

        ScatterData scatterData = new ScatterData(scatterDataSets);
        scatterData.setHighlightEnabled(false);
        mScatterChart.setData(scatterData);

        XAxis xAxis3 = mScatterChart.getXAxis();
        xAxis3.setGranularity(1f);
        mScatterChart.invalidate();
    }

    private LineDataSet getDataSet(List<Entry> list, String title, int color){
        LineDataSet lineDataSet = new LineDataSet(list, title);
        lineDataSet.setColor(color);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setCircleColor(color);
        return lineDataSet;
    }

    private ScatterDataSet getScatterDataSet(List<Entry> list, String title, int color){
        ScatterDataSet dataSet = new ScatterDataSet(list, title);
        dataSet.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        dataSet.setScatterShapeHoleColor(color);
        dataSet.setScatterShapeHoleRadius(8f);
        dataSet.setColor(color);
        return dataSet;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Back button pressed ", "true");
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
