# firefoxes
manage multiple independant firefox profiles

These arent really profiles, instead they are completely independent
copies of both the firefox install and a faked $HOME

It is easy to create new ones and blow them away. With a bit of tweaking
you can also run different versions of firefox. You can also clone one of
the clones.

run setup and follow instructions. once you have done that you
will have the following scripts:
- `ff`        launches one of your firefox 'profiles'
- `ff-list`   lists all your profiles
- `ff-clone`  makes a copy from `default` or from source specified
- `ff-rm`     deletes a copy
- `ff-name`   makes a background image from name of clone
  - note `ff-name` is no longer working after version 66(~ish)

## motivation
After ff 57, one of my favorite plugins no longer worked (tab groups). There were similar
plugins, unfortunately I couldn't find one that kept the history of tabs that were in a tab group.
Thats really what this was for. I could have achieved most of this just with profiles and a native
system install of firefox, but profiles are annoying (dont like to have to choose them with a mouse).
So I created a system where I could do everything from the command line, with the added benefit of
being able to run different versions of firefox.

## other features
  - tabs are multirow
  - background image (like a theme) will show the name of your independant profile

## TODO

### important
  - make auto-clone on non-existing 'profile'
    - this is on hold till i decide if i really want it
  - consider making up a naming convention like `foo-bar` - will launch if `foo-bar` exists otherwise
    will clone `foo-bar` from `foo`
### not so important
  - round those tab corners!


