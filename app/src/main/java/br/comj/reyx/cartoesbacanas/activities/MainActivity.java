package br.comj.reyx.cartoesbacanas.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;

import br.comj.reyx.cartoesbacanas.R;
import br.comj.reyx.cartoesbacanas.objects.CardStack;
import br.comj.reyx.cartoesbacanas.objects.TicketCard;
import br.comj.reyx.cartoesbacanas.views.CardUI;


public class MainActivity extends AppCompatActivity {

    private CardUI mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init CardView
        mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(true);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCardView.getScrollView().scrollTo(0, mCardView.getScrollView().getHeight());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(Uri.parse("http://www.androidviews.net/"));
                // startActivity(intent);
            }
        };

        ArrayList<TicketCard> cards = new ArrayList<TicketCard>();
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tr_sem_linha));
        cards.add(new TicketCard("349,19", "01/06/2015", "18,93", R.drawable.cartao_tr_sem_linha));
        cards.add(new TicketCard("0,00", "29/05/2015", "33,19", R.drawable.cartao_tc_sem_linha));
        cards.add(new TicketCard("8,92", "05/06/2015", "11,11", R.drawable.cartao_tcar_sem_linha));
        cards.add(new TicketCard("1940,37", "15/06/2015", "17,40", R.drawable.cartao_tcar_sem_linha));
        cards.add(new TicketCard("7,99", "22/05/2015", "23,31", R.drawable.cartao_ta_sem_linha));
        cards.add(new TicketCard("215,40", "22/05/2015", "23,31", R.drawable.cartao_ta_sem_linha));
        cards.add(new TicketCard("112,98", "22/05/2015", "23,31", R.drawable.cartao_tt_sem_linha));

        // add AndroidViews Cards
        for (TicketCard card : cards) {
            mCardView.addCardToLastStack(card);
            card.setOnClickListener(listener);
        }

        // draw cards
        mCardView.refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
