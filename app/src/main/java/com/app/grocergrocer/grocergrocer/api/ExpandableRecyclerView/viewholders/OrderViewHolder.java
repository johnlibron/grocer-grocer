package com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.models.ExpandableGroup;
import com.app.grocergrocer.grocergrocer.models.Order;
import com.app.grocergrocer.grocergrocer.ui.OrderDetailsActivity;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class OrderViewHolder extends GroupViewHolder {

    private TextView orderName;
    private TextView orderDate;
    private ImageView arrow;
    private Button btnManageOrder;

    public OrderViewHolder(View itemView) {
        super(itemView);
        orderName = (TextView) itemView.findViewById(R.id.list_item_order_no);
        orderDate = (TextView) itemView.findViewById(R.id.list_item_order_date);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_header_arrow);
        btnManageOrder = (Button) itemView.findViewById(R.id.btn_manage_order);
    }

    public void setOrder(ExpandableGroup order) {
        if (order instanceof Order) {
            orderName.setText(order.getOrderNo());
            orderDate.setText(order.getOrderDate());
        }
    }

    public void setManageOrder(final ExpandableGroup order) {
        if (order instanceof Order) {
            btnManageOrder.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, OrderDetailsActivity.class);
                    intent.putExtra("orderNo", order.getOrderNo());
                    intent.putExtra("orderDate", order.getOrderDate());
                    context.startActivity(intent);
                }
            });
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
