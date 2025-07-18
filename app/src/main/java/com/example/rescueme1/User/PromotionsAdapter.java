package com.example.rescueme1.User;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rescueme1.DB.PromotionsModel;
import com.example.rescueme1.R;
import java.util.List;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.PromotionViewHolder> {

    private Context context;
    private List<PromotionsModel> promotionsList;

    public PromotionsAdapter(Context context, List<PromotionsModel> promotionsList) {
        this.context = context;
        this.promotionsList = promotionsList;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.u_promo_cardview, parent, false);
        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder holder, int position) {
        PromotionsModel promotion = promotionsList.get(position);

        holder.title.setText(promotion.getTitle());

        byte[] imageBytes = promotion.getImage();
        if (imageBytes != null && imageBytes.length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            holder.promImg.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return promotionsList.size();
    }

    public static class PromotionViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView promImg;

        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            promImg = itemView.findViewById(R.id.promimg);
        }
    }
}