using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.LotteryNumberGenerator
{
    /// <summary>
    /// Query options for the Lottery Number Generator API
    /// </summary>
    public class LotteryNumberGeneratorQueryOptions
    {
        /// <summary>
        /// Lottery game preset (custom, powerball, megamillions, euromillions, eurojackpot, lotto649)
        /// Example: powerball
        /// </summary>
        [JsonProperty("game")]
        public string Game { get; set; }

        /// <summary>
        /// Number of main numbers to pick (1-20) - for custom game
        /// Example: 6
        /// </summary>
        [JsonProperty("numbers")]
        public string Numbers { get; set; }

        /// <summary>
        /// Maximum number for main numbers (10-100) - for custom game
        /// Example: 49
        /// </summary>
        [JsonProperty("max")]
        public string Max { get; set; }

        /// <summary>
        /// Number of bonus numbers (0-5) - for custom game
        /// Example: 1
        /// </summary>
        [JsonProperty("bonus")]
        public string Bonus { get; set; }

        /// <summary>
        /// Number of tickets to generate (1-100)
        /// Example: 3
        /// </summary>
        [JsonProperty("tickets")]
        public string Tickets { get; set; }
    }
}
