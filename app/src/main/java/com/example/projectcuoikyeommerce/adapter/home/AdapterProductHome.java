package com.example.projectcuoikyeommerce.adapter.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcuoikyeommerce.R;
import com.example.projectcuoikyeommerce.event.home.ProductHomeEvent;
import com.example.projectcuoikyeommerce.model.Product;

import java.util.List;

public class AdapterProductHome extends RecyclerView.Adapter<ViewHolderProduct> {
    private List<Product> listProduct;
    private ProductHomeEvent productHomeEvent;

    public AdapterProductHome(List<Product> listProduct, ProductHomeEvent productHomeEvent) {
        this.listProduct = listProduct;
        this.productHomeEvent = productHomeEvent;
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        ViewHolderProduct viewHolderProduct=new ViewHolderProduct(view).linkAdapter(this);
        return viewHolderProduct;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct holder, int position) {
        Product product=listProduct.get(position);
//        holder.titleProductView.setText(product.getName());
//        holder.branchProductView.setText(product.getBranch().getName());
//        holder.priceProductView.setText(product.getPrice()+"");
        holder.imageProductView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productHomeEvent.onClickItem();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
}
class ViewHolderProduct extends RecyclerView.ViewHolder{
    AdapterProductHome adapter;
    ImageView imageProductView;
    TextView titleProductView;
    TextView branchProductView;
    TextView priceProductView;

    public ViewHolderProduct(@NonNull View itemView) {
        super(itemView);
        imageProductView=itemView.findViewById(R.id.item_product_image);
        titleProductView=itemView.findViewById(R.id.item_product_name);
        branchProductView=itemView.findViewById(R.id.item_product_branch);
        priceProductView=itemView.findViewById(R.id.item_product_price);

    }
    public ViewHolderProduct linkAdapter(AdapterProductHome adapter){
        this.adapter=adapter;
        return this;
    }
}
