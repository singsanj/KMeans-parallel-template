# Vanilla Engine Template

## Documentation

Please refer to http://docs.prediction.io/templates/vanilla/quickstart/

## Versions

### v0.3.0

- update for PredictionIO 0.9.2, including:

  - use new PEventStore API
  - use appName in DataSource parameter


### v0.2.0

- update for PredictionIO 0.9.2

### v0.1.1

- update build.sbt and template.json for PredictionIO 0.9.2

### v0.1.0

- initial version

# How to use it

- clone the repository
- cd "cloned directory"
- pio app new MyApp1
- capture the app access_id and app_id. Keep these handy
- vi engine.json (provide the captured app_id)
- vi scripts/loadData.py (update the access_key)
- pio build --verbose or pio build
- pio train
- pio deploy
