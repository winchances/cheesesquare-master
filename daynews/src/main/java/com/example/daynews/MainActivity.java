package com.example.daynews;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.daynews.news.presenter.NewsPresenterImp;
import com.example.daynews.news.widget.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       ViewPager vp= (ViewPager) findViewById(R.id.vp);

        setupViewPager(vp);


      TabLayout tabLayout= (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("热点"));
        tabLayout.addTab(tabLayout.newTab().setText("科技"));
        tabLayout.addTab(tabLayout.newTab().setText("北京"));
        tabLayout.addTab(tabLayout.newTab().setText("社会"));

        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
        tabLayout.addTab(tabLayout.newTab().setText("汽车"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("军事"));
        tabLayout.addTab(tabLayout.newTab().setText("财经"));

        tabLayout.addTab(tabLayout.newTab().setText("星座"));
        tabLayout.addTab(tabLayout.newTab().setText("搞笑"));
        tabLayout.addTab(tabLayout.newTab().setText("游戏"));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(vp);

    }

    private void setupViewPager(ViewPager vp) {
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_RECOMMEND),"推荐");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_HOTSPOT),"热点");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_TECH),"科技");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_BEJING),"北京");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_SOCIETY),"社会");

        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_AMUSE),"娱乐");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_CAR),"汽车");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_PHYSICAL),"体育");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_WAR),"军事");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_FINANCE),"财经");

        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_CONSTEL),"星座");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_FUNNY),"搞笑");
        adapter.addFragment(NewsListFragment.newInstance(NewsPresenterImp.NEWS_TYPE_GAME),"游戏");


        vp.setAdapter(adapter);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class MyAdapter extends FragmentPagerAdapter{

        private List<Fragment> list;
        private List<String> title_list;

        public void addFragment(Fragment fragment,String title){
            list.add(fragment);
            title_list.add(title);
        }

        public MyAdapter(FragmentManager fm) {
            super(fm);
            list=new ArrayList<>();
            title_list=new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title_list.get(position);
        }
    }


}
