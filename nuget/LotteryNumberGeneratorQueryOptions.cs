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
        /// Lottery game preset
        /// </summary>
        [JsonProperty("game")]
        public string Game { get; set; }

        /// <summary>
        /// Number of main numbers to pick (for custom game)
        /// </summary>
        [JsonProperty("numbers")]
        public int? Numbers { get; set; }

        /// <summary>
        /// Maximum number for main numbers (for custom game)
        /// </summary>
        [JsonProperty("max")]
        public int? Max { get; set; }

        /// <summary>
        /// Number of bonus numbers (for custom game)
        /// </summary>
        [JsonProperty("bonus")]
        public int? Bonus { get; set; }

        /// <summary>
        /// Number of tickets to generate
        /// </summary>
        [JsonProperty("tickets")]
        public int? Tickets { get; set; }
    }
}
