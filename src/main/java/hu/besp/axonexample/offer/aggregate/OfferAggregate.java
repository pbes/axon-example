package hu.besp.axonexample.offer.aggregate;

import hu.besp.axonexample.offer.command.CreateOfferCommand;
import hu.besp.axonexample.offer.command.DeleteOfferCommand;
import hu.besp.axonexample.offer.entity.OfferState;
import hu.besp.axonexample.offer.event.OfferCreatedEvent;
import hu.besp.axonexample.offer.event.OfferRevokedEvent;
import hu.besp.axonexample.offer.exception.OfferAlreadyRevokedException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class OfferAggregate {

    @AggregateIdentifier
    private String id;
    private OfferState state;

    @CommandHandler
    public OfferAggregate(CreateOfferCommand command) {
        var e = new OfferCreatedEvent(
                command.getId(),
                command.getProduct(),
                command.getUserId(),
                command.getOfferType(),
                OfferState.CREATED,
                command.getQuantity(),
                command.getPrice()
        );
        apply(e);
    }

    protected OfferAggregate() {

    }

    @CommandHandler
    public void handle(DeleteOfferCommand command) throws OfferAlreadyRevokedException {
        if (this.state == OfferState.REVOKED) {
            throw new OfferAlreadyRevokedException();
        }

        apply(new OfferRevokedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(OfferCreatedEvent event) {
        this.id = event.getOfferId();
        this.state = event.getState();
    }

    @EventSourcingHandler
    public void on(OfferRevokedEvent event) {
        this.state = OfferState.REVOKED;
    }

}
