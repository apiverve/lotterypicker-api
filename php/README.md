# Lottery Number Generator API - PHP Package

Lottery Number Generator creates random lottery numbers for various popular games including Powerball, Mega Millions, EuroMillions, and custom lottery configurations.

## Installation

Install via Composer:

```bash
composer require apiverve/lotterypicker
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Lotterypicker\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'game' => 'custom',
    'numbers' => 6,
    'max' => 49,
    'bonus' => 1,
    'tickets' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Lotterypicker\Client;
use APIVerve\Lotterypicker\Exceptions\APIException;
use APIVerve\Lotterypicker\Exceptions\ValidationException;

try {
    $response = $client->execute(['game' => 'custom', 'numbers' => 6, 'max' => 49, 'bonus' => 1, 'tickets' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/lotterypicker?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/lotterypicker?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/lotterypicker?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
