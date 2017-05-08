package com.example.tommorow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;


import com.example.tommorow.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/4/22.
 * view class
 * pie chart
 */
public class PieChartView extends View {

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    /**
     * piechart radius
     */
    private float pieChartCircleRadius = 100;

    private float textBottom;
    /**
     * text size
     */
    private float mTextSize = 14;

    private RectF pieChartCircleRectF = new RectF();

    private List<PieceDataHolder> pieceDataHolders = new ArrayList<>();


    /**
     * the length of marker
     */
    private float markerLineLength = 30f;

    public PieChartView(Context context) {
        super(context);
        init(null, 0);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.PieChartView, defStyle, 0);

        pieChartCircleRadius = a.getDimension(
                R.styleable.PieChartView_circleRadius,
                pieChartCircleRadius);

        mTextSize = a.getDimension(R.styleable.PieChartView_textSize, mTextSize)/getResources().getDisplayMetrics().density;

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);


        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, mTextSize, getContext().getResources().getDisplayMetrics()));

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.descent - fontMetrics.ascent;
        textBottom = fontMetrics.bottom;
    }

    /**
     * set pieChartCircleRadius
     *
     * @param pieChartCircleRadius 饼状图的半径（px）
     */
    public void setPieChartCircleRadius(int pieChartCircleRadius) {

        this.pieChartCircleRadius = pieChartCircleRadius;

        invalidate();
    }

    /**
     * markerLineLength
     *
     * @param markerLineLength markerLineLength（px）
     */
    public void setMarkerLineLength(int markerLineLength) {
        this.markerLineLength = markerLineLength;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        initPieChartCircleRectF();

        drawAllSectors(canvas);

    }

    private void drawAllSectors(Canvas canvas) {
        float sum = 0f;
        for (PieceDataHolder pieceDataHolder : pieceDataHolders) {
            sum += pieceDataHolder.value;
        }

        float sum2 = 0f;
        for (PieceDataHolder pieceDataHolder : pieceDataHolders) {
            float startAngel = sum2 / sum * 360;
            sum2 += pieceDataHolder.value;
            float sweepAngel = pieceDataHolder.value / sum * 360;

            drawSector(canvas, pieceDataHolder.color, startAngel, sweepAngel);
            drawMarkerLineAndText(canvas, pieceDataHolder.color, startAngel + sweepAngel / 2, pieceDataHolder.marker);
        }
    }

    private void initPieChartCircleRectF() {
        pieChartCircleRectF.left = getWidth() / 2 - pieChartCircleRadius;
        pieChartCircleRectF.top = getHeight() / 2 - pieChartCircleRadius;
        pieChartCircleRectF.right = pieChartCircleRectF.left + pieChartCircleRadius * 2;
        pieChartCircleRectF.bottom = pieChartCircleRectF.top + pieChartCircleRadius * 2;
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.(sp)
     */
    public float getTextSize() {
        return mTextSize;
    }

    /**
     * Sets the view's text dimension attribute value. In the PieChartView view, this dimension
     * is the font size.
     *
     * @param textSize The text dimension attribute value to use.(sp)
     */
    public void setTextSize(float textSize) {
        mTextSize = textSize;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * set the data of pie chart
     *
     * @param data
     */
    public void setData(List<PieceDataHolder> data) {

        if (data != null) {
            pieceDataHolders.clear();
            pieceDataHolders.addAll(data);
        }

        invalidate();
    }

    /**
     * draw pie chart
     *
     * @param canvas
     * @param color
     * @param startAngle
     * @param sweepAngle
     */
    protected void drawSector(Canvas canvas, int color, float startAngle, float sweepAngle) {

        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        canvas.drawArc(pieChartCircleRectF, startAngle, sweepAngle, true, paint);

    }

    /**
     *
     *
     * @param canvas
     * @param color
     * @param rotateAngel
     */
    protected void drawMarkerLineAndText(Canvas canvas, int color, float rotateAngel, String text) {
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);

        Path path = new Path();
        path.close();
        path.moveTo(getWidth() / 2, getHeight() / 2);
        final float x = (float) (getWidth() / 2 + (markerLineLength + pieChartCircleRadius) * Math.cos(Math.toRadians(rotateAngel)));
        final float y = (float) (getHeight() / 2 + (markerLineLength + pieChartCircleRadius) * Math.sin(Math.toRadians(rotateAngel)));
        path.lineTo(x, y);
        float landLineX;
        if (270f > rotateAngel && rotateAngel > 90f) {
            landLineX = x - 20;
        } else {
            landLineX = x + 20;
        }
        path.lineTo(landLineX, y);
        canvas.drawPath(path, paint);

        mTextPaint.setColor(color);
        if (270f > rotateAngel && rotateAngel > 90f) {
            float textWidth = mTextPaint.measureText(text);
            canvas.drawText(text, landLineX - textWidth, y + mTextHeight / 2 - textBottom, mTextPaint);

        } else {
            canvas.drawText(text, landLineX, y + mTextHeight / 2 - textBottom, mTextPaint);
        }

    }

    /**
     * PieceDataHolder
     */
    public static final class PieceDataHolder {

        private float value;
        private int color;
        private String marker;
        public PieceDataHolder(float value, int color, String marker) {
            this.value = value;
            this.color = color;
            this.marker = marker;
        }
    }

}
