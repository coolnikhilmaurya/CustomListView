package in.nikhil.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        // generating list of dummy Objects for populating listView
        final List<Item> list=new ArrayList<>();
        for(int i=0;i<50;i++){
            Item item=new Item();
            item.Heading="Heading - "+i;
            item.SubHeading="SubHead - "+i;

            list.add(item);
        }

        // Instantiating the CustomListAdapter
        CustomListAdapter customListAdapter = new CustomListAdapter(list);

        // Setting the ListViw adapter
        ListView listView = findViewById(R.id.myListView);

        // Displaying a simple Toast OnClick of any of our CustomListView item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListActivity.this,"You clicked - "+list.get(position).Heading,Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(customListAdapter);


    }
}
