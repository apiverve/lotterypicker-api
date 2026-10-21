# Lottery Number Generator API - Ruby Gem

Lottery Number Generator creates random lottery numbers for various popular games including Powerball, Mega Millions, EuroMillions, and custom lottery configurations.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_lotterypicker'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_lotterypicker
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_lotterypicker'

# Initialize the client
client = APIVerve::Lotterypicker::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  game: "custom",
  numbers: 6,
  max: 49,
  bonus: 1,
  tickets: 1,
  bonusmax: 10
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ game: "custom", numbers: 6, max: 49, bonus: 1, tickets: 1, bonusmax: 10 })
  puts response["data"]
rescue APIVerve::Lotterypicker::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Lotterypicker::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Lotterypicker::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "game": "Powerball (US)",
    "game_type": "powerball",
    "config": {
      "main_numbers_count": 5,
      "main_numbers_range": "1-69",
      "bonus_numbers_count": 1,
      "bonus_numbers_range": "1-26"
    },
    "tickets_generated": 3,
    "tickets": [
      {
        "ticket_number": 1,
        "main_numbers": [
          11,
          12,
          51,
          53,
          58
        ],
        "bonus_numbers": [
          3
        ]
      },
      {
        "ticket_number": 2,
        "main_numbers": [
          4,
          24,
          28,
          46,
          61
        ],
        "bonus_numbers": [
          3
        ]
      },
      {
        "ticket_number": 3,
        "main_numbers": [
          12,
          13,
          29,
          49,
          60
        ],
        "bonus_numbers": [
          6
        ]
      }
    ]
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/lotterypicker?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/lotterypicker?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/lotterypicker?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
