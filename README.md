# firefoxes
manage multiple independant firefox instances

An ff instance is a  completely independent copy of both the firefox install and a faked $HOME.
It can be considered a little like a more powerful profile.

It is easy to create new ones and blow them away. With a bit of tweaking
you can also run different versions of firefox. You can also clone one of
the clones.

run setup and follow instructions. once you have done that you
will have the following scripts:
- `ff`        launches one of your firefox instances
- `ff-list`   lists all your instances, can do a regex search
- `ff-clone`  makes a copy from `default` or from source specified
- `ff-rm`     deletes a copy
- `ff-chrome` copies designated userChrome file to one or more instances
- `ff-name`   makes a background image from name of clone
  - note `ff-name` is no longer working after version 66(~ish)

## motivation
After ff 57, one of my favorite plugins no longer worked (tab groups). There were similar
plugins, unfortunately I couldn't find one that kept the history of tabs that were in a tab group.
Thats really what this was for. I could have achieved most of this just with profiles and a native
system install of firefox, but profiles are annoying (dont like to have to choose them with a mouse).
So I created a system where I could do everything from the command line, with the added benefit of
being able to run different versions of firefox.

Also with this system and something like `noScript` you can limit the amount of `.js` you allow in each instance.
So if you (shudder) use facebook, you can allow the facebook js in only the facebook instance.

## other features
  - tabs are multirow
  - multirow tabs are achieved via `userChrome.css`. There is also a command to update this file
  - background image (like a theme) will show the name of your independant instance (note - currently broken)

## TODO

### code smells
  - the use of variables is getting a bit shakey
    - I think all functions should be passed `$@` like `chrome` not make assumptions about `$2` etc like `clone`
    - theres a bunch of vars being declared up the top that only get used inside one func - maybe they should be moved
  - also the giant if/else down the bottom is getting wordy. Too much meta programming makes baby jesus cry - but maybe just a little?
  - its getting a bit hard to test everything now. time for some automation?
### future
  - make auto-clone on non-existing 'instance'
    - this is on hold till i decide if i really want it
  - consider making up a naming convention like `foo-bar` - will launch if `foo-bar` exists otherwise
    will clone `foo-bar` from `foo`
### not so important
  - round those tab corners!


