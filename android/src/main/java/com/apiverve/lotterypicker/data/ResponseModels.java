// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     LotteryNumberGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.lotterypicker.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static LotteryNumberGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(LotteryNumberGeneratorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(LotteryNumberGeneratorData.class);
        writer = mapper.writerFor(LotteryNumberGeneratorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// LotteryNumberGeneratorData.java

package com.apiverve.lotterypicker.data;

import com.fasterxml.jackson.annotation.*;

public class LotteryNumberGeneratorData {
    private String game;
    private String gameType;
    private Config config;
    private long ticketsGenerated;
    private Ticket[] tickets;
    private String[] availableGames;

    @JsonProperty("game")
    public String getGame() { return game; }
    @JsonProperty("game")
    public void setGame(String value) { this.game = value; }

    @JsonProperty("game_type")
    public String getGameType() { return gameType; }
    @JsonProperty("game_type")
    public void setGameType(String value) { this.gameType = value; }

    @JsonProperty("config")
    public Config getConfig() { return config; }
    @JsonProperty("config")
    public void setConfig(Config value) { this.config = value; }

    @JsonProperty("tickets_generated")
    public long getTicketsGenerated() { return ticketsGenerated; }
    @JsonProperty("tickets_generated")
    public void setTicketsGenerated(long value) { this.ticketsGenerated = value; }

    @JsonProperty("tickets")
    public Ticket[] getTickets() { return tickets; }
    @JsonProperty("tickets")
    public void setTickets(Ticket[] value) { this.tickets = value; }

    @JsonProperty("available_games")
    public String[] getAvailableGames() { return availableGames; }
    @JsonProperty("available_games")
    public void setAvailableGames(String[] value) { this.availableGames = value; }
}

// Config.java

package com.apiverve.lotterypicker.data;

import com.fasterxml.jackson.annotation.*;

public class Config {
    private long mainNumbersCount;
    private String mainNumbersRange;
    private long bonusNumbersCount;
    private String bonusNumbersRange;

    @JsonProperty("main_numbers_count")
    public long getMainNumbersCount() { return mainNumbersCount; }
    @JsonProperty("main_numbers_count")
    public void setMainNumbersCount(long value) { this.mainNumbersCount = value; }

    @JsonProperty("main_numbers_range")
    public String getMainNumbersRange() { return mainNumbersRange; }
    @JsonProperty("main_numbers_range")
    public void setMainNumbersRange(String value) { this.mainNumbersRange = value; }

    @JsonProperty("bonus_numbers_count")
    public long getBonusNumbersCount() { return bonusNumbersCount; }
    @JsonProperty("bonus_numbers_count")
    public void setBonusNumbersCount(long value) { this.bonusNumbersCount = value; }

    @JsonProperty("bonus_numbers_range")
    public String getBonusNumbersRange() { return bonusNumbersRange; }
    @JsonProperty("bonus_numbers_range")
    public void setBonusNumbersRange(String value) { this.bonusNumbersRange = value; }
}

// Ticket.java

package com.apiverve.lotterypicker.data;

import com.fasterxml.jackson.annotation.*;

public class Ticket {
    private long ticketNumber;
    private long[] mainNumbers;
    private long[] bonusNumbers;

    @JsonProperty("ticket_number")
    public long getTicketNumber() { return ticketNumber; }
    @JsonProperty("ticket_number")
    public void setTicketNumber(long value) { this.ticketNumber = value; }

    @JsonProperty("main_numbers")
    public long[] getMainNumbers() { return mainNumbers; }
    @JsonProperty("main_numbers")
    public void setMainNumbers(long[] value) { this.mainNumbers = value; }

    @JsonProperty("bonus_numbers")
    public long[] getBonusNumbers() { return bonusNumbers; }
    @JsonProperty("bonus_numbers")
    public void setBonusNumbers(long[] value) { this.bonusNumbers = value; }
}