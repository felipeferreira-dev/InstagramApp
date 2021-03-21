package br.com.dev.felipeferreira.instagramremake.login.presentation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import br.com.dev.felipeferreira.instagramremake.R;

public class TestButton extends FrameLayout {

    private AppCompatButton button;
    private ProgressBar progress;
    private String text;

    public TestButton(@NonNull Context context) {
        super(context);
        setup(context, null);
    }

    public TestButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
    }

    public TestButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.button_loading, this, true);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestButton, 0, 0);
        text = typedArray.getString(R.styleable.TestButton_text);
        typedArray.recycle();

        button = (AppCompatButton) getChildAt(0);
        button.setText(text);
        button.setEnabled(false);

        progress = (ProgressBar) getChildAt(1);

        progress.getIndeterminateDrawable().setColorFilter(
                ContextCompat.getColor(context, android.R.color.white), PorterDuff.Mode.SRC_IN);

        progress.setVisibility(VISIBLE);

    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        button.setOnClickListener(l);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        button.setEnabled(enabled);
    }

    public void showProgress(boolean enabled) {
        progress.setVisibility(enabled ? VISIBLE : GONE);
        button.setText(enabled ? "" : text);
    }
}
