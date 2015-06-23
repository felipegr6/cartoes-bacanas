package br.comj.reyx.cartoesbacanas.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by regis.silva on 22/06/2015.
 */
public class CardNumberTextView extends TextView {
    public CardNumberTextView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init();

    }

    public CardNumberTextView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init();

    }

    public CardNumberTextView(Context context) {

        super(context);
        init();

    }

    public void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/credit-card.regular.ttf");
        setTypeface(tf);

    }
}
