package com.example.wguscheduler;

import android.content.Intent;
import android.os.Bundle;

import com.example.wguscheduler.edit.TermEdit;
import com.example.wguscheduler.model.Term;
import com.example.wguscheduler.viewmodel.MainViewModel;
import com.example.wguscheduler.viewmodel.TermAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @OnClick(R.id.fab)
    void fabClickHandler(){
        Intent intent = new Intent(this, TermEdit.class);
        startActivity(intent);
    }

    private List<Term> termData = new ArrayList<>();
    private TermAdapter mAdapter;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        initRecyclerView();
        initViewModel();
    }

    private void initRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initViewModel() {
        final Observer<List<Term>> termObserver =
                new Observer<List<Term>>() {
                    @Override
                    public void onChanged(List<Term> termEntities) {
                        termData.clear();
                        termData.addAll(termEntities);

                        if (mAdapter == null) {
                            mAdapter = new TermAdapter(termData, MainActivity.this);
                            mRecyclerView.setAdapter(mAdapter);
                        } else {
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                };
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.mTerms.observe(this, termObserver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_data) {
            addSampleData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addSampleData() {
        mViewModel.addSampleData();
    }
}
