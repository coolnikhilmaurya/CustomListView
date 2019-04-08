package in.nikhil.customlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Item> list;

    // receiving the list of items through constructor
    CustomListAdapter(List<Item> list) {
        this.list = list;
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
        // this method is being called by adapter every time it needs to display new item in ListView
        if(convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutom_list_item, parent, false);
        }

        // Getting the references of Views and customizing them as per our requirement
        TextView tvHead = convertView.findViewById(R.id.tvHead);
        TextView tvSubHead = convertView.findViewById(R.id.tvSubHead);

        tvHead.setText(list.get(position).Heading);
        tvSubHead.setText(list.get(position).SubHeading);

        // finally returning the populated data View
        return convertView;
    }
}
