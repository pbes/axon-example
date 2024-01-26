package hu.besp.axonexample.offer.command;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@RequiredArgsConstructor
public class DeleteOfferCommand {
    @TargetAggregateIdentifier
    private final String id;
}
