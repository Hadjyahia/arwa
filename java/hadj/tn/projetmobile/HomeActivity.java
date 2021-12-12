package hadj.tn.projetmobile;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.ProductCategory;
import Model.Products;
import adapter.ProductAdapter;
import adapter.ProductCategoryAdapter;

public class HomeActivity extends AppCompatActivity {


    RecyclerView productCatRecycler, prodItemRecycler;
    ProductCategoryAdapter productCategoryAdapter;
    ProductAdapter productAdapter;
    DatabaseReference database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "All Body Products"));
        productCategoryList.add(new ProductCategory(4, "Skin Care"));
        productCategoryList.add(new ProductCategory(5, "Hair Care"));
        productCategoryList.add(new ProductCategory(6, "Make Up"));
        productCategoryList.add(new ProductCategory(7, "Fragrance"));
        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
       /* productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.choc1));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.choc1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.choc1));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.choc1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.choc1));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.choc1));*/

        setProdItemRecycler(productsList);

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        database = FirebaseDatabase.getInstance().getReference("Products");
        prodItemRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Products products = dataSnapshot.getValue(Products.class);
                    productsList.add(products);
                }
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
