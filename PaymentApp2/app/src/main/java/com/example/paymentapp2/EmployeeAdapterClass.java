package com.example.paymentapp2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapterClass extends RecyclerView.Adapter<EmployeeAdapterClass.ViewHolder> {

    List<PayMethodModelClass> employee;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public EmployeeAdapterClass(List<PayMethodModelClass> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.employee_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final PayMethodModelClass employeeModelClass = employee.get(position);

        holder.editText_Name.setText(employeeModelClass.getName());
        holder.editText_Email.setText(String.valueOf(employeeModelClass.getCarno()));
        holder.edittext_email2.setText(String.valueOf(employeeModelClass.getCvv()));
        holder.edittext_email3.setText(employeeModelClass.getExpdate());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringEmail2 = holder.edittext_email2.getText().toString();
                String stringEmail3 = holder.edittext_email3.getText().toString();

                databaseHelperClass.updateEmployee(new PayMethodModelClass(stringName,stringEmail,stringEmail2,stringEmail3));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(employeeModelClass.getId());
                employee.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((Activity) context).finish();
                context.startActivity(new Intent(context,PaymentStatus.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EditText editText_Name;
        EditText editText_Email;
        EditText edittext_email2;
        EditText edittext_email3;

        Button button_Edit;
        Button button_delete;
        Button button_pay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            edittext_email2 = itemView.findViewById(R.id.edittext_email2);
            edittext_email3 = itemView.findViewById(R.id.edittext_email3);

            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);
            button_pay = itemView.findViewById(R.id.button_pay);

        }
    }
}
