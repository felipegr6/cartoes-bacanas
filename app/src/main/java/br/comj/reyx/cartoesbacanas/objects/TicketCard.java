package br.comj.reyx.cartoesbacanas.objects;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.comj.reyx.cartoesbacanas.R;

/**
 * Created by User on 27/05/2015.
 */
public class TicketCard extends RecyclableCard {
    private Integer resourceId;

    public TicketCard(String saldo, String proximoLancamento, String ticketMedio, Integer resourceId) {
        super(saldo, proximoLancamento, ticketMedio, "#e00707", "#e00707", false, false);
        this.resourceId = resourceId;
    }

    @Override
    protected void applyTo(View convertView) {
        ((TextView) convertView.findViewById(R.id.text_saldo)).setText(title);
        ((TextView) convertView.findViewById(R.id.text_proximo_lancamento)).setText(titlePlay);
        ((TextView) convertView.findViewById(R.id.text_ticket_medio)).setText(description);
        ((ImageView) convertView.findViewById(R.id.image_card)).setImageResource(resourceId);
    }

    @Override
    protected int getCardLayoutId() {
        return R.layout.card_ticket;
    }

}
