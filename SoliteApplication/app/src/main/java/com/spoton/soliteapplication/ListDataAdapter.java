package com.spoton.soliteapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shashi on 1/13/16.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list=new ArrayList();
    ListView lview;
  public  ListDataAdapter(Context context,int resource) {
      super(context, resource);
  }


    public static class LayoutHandler{
         TextView rrno,nname,aaddr,cclas,mmarks;
    }
    @Override
    public void  add(Object object){
        super.add(object);
        list.add(object);
    }

      @Override
    public int getCount(){return list.size()+1;}

    @Override
    public Object getItem(int position){return list.get(position);  }

       @Override
    public View getView(int position,View convertView ,ViewGroup parent){
        View row=convertView;
        LayoutHandler layoutHandler = null;
        if(row == null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row=layoutInflater.inflate(R.layout.row_layout,parent,false);
             layoutHandler =new LayoutHandler();
            layoutHandler.rrno=(TextView)row.findViewById(R.id.rid);
            layoutHandler.nname=(TextView)row.findViewById(R.id.name);
            layoutHandler.aaddr=(TextView)row.findViewById(R.id.add);
            layoutHandler.cclas=(TextView)row.findViewById(R.id.clas);
            layoutHandler.mmarks=(TextView)row.findViewById(R.id.mark);
            row.setTag(layoutHandler);



        }
        else
        {
            layoutHandler = (LayoutHandler)row.getTag();
        }

           if(position != 0) {
               DateProvider dateProvider = (DateProvider) this.getItem(position - 1);
               layoutHandler.rrno.setText(dateProvider.getRno());
               layoutHandler.nname.setText(dateProvider.getNam());
               layoutHandler.aaddr.setText(dateProvider.getAdd());
               layoutHandler.cclas.setText(dateProvider.getClas());
               layoutHandler.mmarks.setText(dateProvider.getMarks());
           }
        return row;
    }


    public void removeItemAtPosition(int pPosition)
    {
        list.remove(pPosition-1);
        notifyDataSetChanged();
    }
}
