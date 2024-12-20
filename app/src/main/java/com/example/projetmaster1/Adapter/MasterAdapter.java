package com.example.projetmaster1.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Etudiant;
import com.example.projetmaster1.models.Master;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class MasterAdapter extends ArrayAdapter<Master> implements Filterable {
    private ArrayList<Master> items;
    private ArrayList<Master> filteredItems;
    private ItemFilter itemFilter = new ItemFilter();

    public MasterAdapter(@NonNull Context context, int resource, ArrayList<Master> items) {
        super(context, resource, items);
        this.items = items;
        this.filteredItems = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        LayoutInflater lf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = lf.inflate(R.layout.master_layout, null);
        TextView master = v.findViewById(R.id.nomMaster);
        TextView des = v.findViewById(R.id.description);
        TextView prof=v.findViewById(R.id.coordinator);
        Master s = getItem(position);
        master.setText(s.getNom());
        prof.setText(s.getCoordinateur());
        des.setText(s.getDescription());
        return v;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return itemFilter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Master> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                // If the constraint is null, return the original list
                filteredList.addAll(items);
            } else {
                // Filter the items based on the constraint
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Master item : items) {
                    if (item.getNom().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // Update the filteredItems with the filtered results
            filteredItems = (ArrayList<Master>) results.values;
            clear();
            addAll(filteredItems);
            notifyDataSetChanged();
        }
    }

}
