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
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(Uri.parse("http://www.androidviews.net/"));
                // startActivity(intent);
            }
        };

        ArrayList<TicketCard> cards = new ArrayList<TicketCard>();
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tr_sem_linha));
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tr_sem_linha));
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tc_sem_linha));
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tcar_sem_linha));
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_tcar_sem_linha));
        cards.add(new TicketCard("154,99", "10/06/2015", "15,58", R.drawable.cartao_ta_sem_linha));

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
