/**
 * Lottery Number Generator API - Basic Usage Example
 *
 * This example demonstrates the basic usage of the Lottery Number Generator API.
 * API Documentation: https://docs.apiverve.com/ref/lotterypicker
 */

const API_KEY = process.env.APIVERVE_API_KEY || 'YOUR_API_KEY_HERE';
const API_URL = 'https://api.apiverve.com/v1/lotterypicker';

/**
 * Make a GET request to the Lottery Number Generator API
 */
async function callLotteryNumberGeneratorAPI() {
  try {
    // Query parameters
    const params &#x3D; new URLSearchParams({
            game: &#x27;powerball&#x27;,
            numbers: 6,
            max: 49,
            bonus: 1,
            tickets: 3
        });

    const response = await fetch(`${API_URL}?${params}`, {
      method: 'GET',
      headers: {
        'x-api-key': API_KEY
      }
    });

    // Check if response is successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();

    // Check API response status
    if (data.status === 'ok') {
      console.log('✓ Success!');
      console.log('Response data:', data.data);
      return data.data;
    } else {
      console.error('✗ API Error:', data.error || 'Unknown error');
      return null;
    }

  } catch (error) {
    console.error('✗ Request failed:', error.message);
    return null;
  }
}

// Run the example
callLotteryNumberGeneratorAPI()
  .then(result => {
    if (result) {
      console.log('\n📊 Final Result:');
      console.log(JSON.stringify(result, null, 2));
    }
  });
