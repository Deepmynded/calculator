package com.app.mycalculator;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CalculatorCardAdapter extends BaseAdapter {
    private Context context;
    private List<CalculatorCard> cardList;

    public CalculatorCardAdapter(Context context, List<CalculatorCard> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Object getItem(int position) {
        return cardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridItem = convertView;
        if (gridItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            gridItem = inflater.inflate(R.layout.calculator_card, parent, false);
        }

        CalculatorCard currentCard = cardList.get(position);

        ImageView icon = gridItem.findViewById(R.id.cardIcon);
        TextView title = gridItem.findViewById(R.id.cardTitle);

        icon.setImageResource(currentCard.getIcon());
        title.setText(currentCard.getTitle());

        return gridItem;
    }
}
