var exec = require('cordova/exec');

exports.IsIgnoringBatteryOptimizations = function (success, error) {
    exec(success, error, 'BatteryOptimizations', 'IsIgnoringBatteryOptimizations', []);
};
