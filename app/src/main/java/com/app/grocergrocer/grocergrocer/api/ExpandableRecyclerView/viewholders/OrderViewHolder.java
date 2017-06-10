package com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.models.ExpandableGroup;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders.GroupViewHolder;
import com.app.grocergrocer.grocergrocer.models.Order;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class OrderViewHolder extends GroupViewHolder {

    private TextView orderName;
    private TextView orderDate;
    private ImageView arrow;

    public OrderViewHolder(View itemView) {
        super(itemView);
        orderName = (TextView) itemView.findViewById(R.id.list_item_order_name);
        orderDate = (TextView) itemView.findViewById(R.id.list_item_order_date);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_header_arrow);
    }

    public void setOrder(ExpandableGroup order) {
        if (order instanceof Order) {
            orderName.setText(order.getOrderName());
            orderDate.setText(order.getOrderDate());
        }
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
