package com.markjmind.jwtools.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * <br>捲土重來<br>
 *
 * @author 오재웅(JaeWoong-Oh)
 * @email markjmind@gmail.com
 * @since 2016-06-07
 */
public class ListViewHolder {
    public HashMap<Integer, View> views = new HashMap();
    private Finder finder;

    public ListViewHolder(View finder){
        initFinder(finder);
    }

    public ListViewHolder(Activity finder){
        initFinder(finder);
    }

    public ListViewHolder(Dialog finder){
        initFinder(finder);
    }

    private void initFinder(final View finder){
        this.finder = new Finder() {
            @Override
            public View findViewById(int id) {
                return finder.findViewById(id);
            }
        };
    }

    private void initFinder(final Activity finder){
        this.finder = new Finder() {
            @Override
            public View findViewById(int id) {
                return finder.findViewById(id);
            }
        };
    }

    private void initFinder(final Dialog finder){
        this.finder = new Finder() {
            @Override
            public View findViewById(int id) {
                return finder.findViewById(id);
            }
        };
    }

    public ListViewHolder add(int... id){
        if(id!=null) {
            for (int i = 0; i < id.length; i++) {
                views.put(id[i], finder.findViewById(id[i]));
            }
        }
        return this;
    }


    public View get(int id){
        return views.get(id);
    }

    public TextView getTextView(int id){
        return (TextView)views.get(id);
    }

    public ImageView getImageView(int id){
        return (ImageView)views.get(id);
    }

    public EditText getEditText(int id){
        return (EditText)views.get(id);
    }

    public Button getButton(int id){
        return (Button)views.get(id);
    }

    public ViewGroup getViewGroup(int id){
        return (ViewGroup)views.get(id);
    }

    public LinearLayout getLinearLayout(int id){
        return (LinearLayout)views.get(id);
    }

    public FrameLayout getFrameLayout(int id){
        return (FrameLayout)views.get(id);
    }

    interface Finder{
        View findViewById(int id);
    }

}