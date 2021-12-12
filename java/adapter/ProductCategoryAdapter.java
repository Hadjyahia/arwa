package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.ProductCategory;
import hadj.tn.projetmobile.R;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductViewHolder> {

    Context context;
    List<ProductCategory> productsList;


    public ProductCategoryAdapter(Context context, List<ProductCategory> productsList) {
        this.context = context;
        this.productsList = productsList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryAdapter.ProductViewHolder holder, int position) {

        holder.categoryName.setText(productsList.get(position).getProductName());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.cat_name);
        }

    }
}
