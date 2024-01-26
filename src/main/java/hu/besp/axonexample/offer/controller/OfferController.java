package hu.besp.axonexample.offer.controller;

import hu.besp.axonexample.offer.command.CreateOfferCommand;
import hu.besp.axonexample.offer.command.DeleteOfferCommand;
import hu.besp.axonexample.offer.dto.CreateOfferDTO;
import hu.besp.axonexample.offer.dto.OfferDTO;
import hu.besp.axonexample.offer.query.ListAllOffersQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final CommandGateway commands;
    private final QueryGateway queries;

    public OfferController(CommandGateway commands, QueryGateway queries) {
        this.commands = commands;
        this.queries = queries;
    }

    @PostMapping()
    public CompletableFuture<Void> createOffer(@RequestBody CreateOfferDTO createOfferDTO) {
        return this.commands.send(new CreateOfferCommand(createOfferDTO));
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteOffer(@PathVariable String id) {
        return this.commands.send(new DeleteOfferCommand(id));
    }

    @GetMapping()
    public CompletableFuture<List<OfferDTO>> getOffers() {
        return this.queries
                .query(
                        new ListAllOffersQuery(),
                        ResponseTypes.multipleInstancesOf(OfferDTO.class)
                );
    }

}
