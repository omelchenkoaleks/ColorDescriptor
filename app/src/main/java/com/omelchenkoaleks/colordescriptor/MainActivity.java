package com.omelchenkoaleks.colordescriptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // нужно получить индекс или позицию, выбранного пользователем элемента
    private Spinner mColorsSpinner;

    // нужно записать описание в этот элемент
    private TextView mTempDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorsSpinner = findViewById(R.id.colors_spinner);
        mTempDescriptionTextView = findViewById(R.id.description_temp_text_view);
    }

    public void showDescription(View view) {
        // сначала нужно получить индекс выбранного элемента
        int position = mColorsSpinner.getSelectedItemPosition();

        /* вызываем созданный метод, который возвращает описание по позиции =
            в этой переменной
                уже есть описание характера пользователя
         */
        String description = getDescriptionByPosition(position);

        // теперь заполняем TextView нужным описанием (данными)
        mTempDescriptionTextView.setText(description);
    }

    private String getDescriptionByPosition(int position) {
        // получаем ресурсы по их имени (string_array) - т.е. здесь массив с данными
        String[] descriptions = getResources().getStringArray(R.array.description_of_temp);
        return descriptions[position];
    }
}
