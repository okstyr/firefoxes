# bb manual

There is a little informaton on what to do in `README.md` and `setup`. But you should probably read this until you are familiar.

Note that this was written after building for firefox and floorp (a firefox-derived browser) some of these steps may be different for non firefox browsers.

## initial setup
- run setup. you should now have a directory called `$HOME/browsers` and an executable and some symlinks in `$HOME/bin`. If `$HOME/bin` is not in your path, either change your path or move those files that `setup` added.
- `cd` into your new `$HOME/browsers` directory. All subsequent commands/paths are assumed to be from this point unless otherwise specified.
- download a browser of your choice, henceforth referred to as `$browser`. Not from your distro's repo, you want a tgz or a zip or something.
- install it to a directory somewhere, for convenience I usually install it under `$HOME/browsers/$browser-build`
- run the executable for the browser. Configure your browser and exit (see [configuration](#configuration))
- Somwhere under `$HOME` it will have created a dotdir. I am going to call this $dotdir. We will use that soon. you can look in the `launch_*` functions for any browsers i have built already, otherwise you will have to find it yourself.
- copy `$browser-build` to `base-$browser-exe`. You can rename if you want, but maybe not if this is your first time.
- create `base-$browser-home` directory as well.
- also `echo $browser > base-$browser-exe/bb-browser`. Note: not literally "$browser". eg `echo floorp > base-floorp-exe/bb-browser`. This is just to make the history nicer.
- now you have to mess about with the profile stuff. See [profiles](#profiles)




## configuration
Note this is specific to firefox and its derivatives. Here's what i usually do:
### settings
- restore last tabs when you start the browser
- don't warn on 'closing' tabs when you shut down.
- do not nag about not being the default browser
- set home page to blank
- add any search engines you may wish to use sometimes (I ususally add yandex)
- set default search engine
- disable anything that is not directly browser related (eg syncing stuff, hints as you type, spellchecking etc)

### extensions
- ghostery
- gitlab markdown
- noscript
- privacy badger
- ublock origin

## profiles
Firefox has a habit of creating new profiles whenever a browser is cloned, but what i want to do is setup a basic profile with the settings and extentions i like, and get all that config each time i clone. All this applies to firefox derived browsers, for others you will have to work it out. Maybe you wont even need this step.

Known dotdir locations:
- firefox      `$HOME/.mozilla/firefox/`
- floorp       `$HOME/.floorp`
More maybe available in the `bb` script in `launch_*` functions


