#!/usr/bin/env bash
set -x

SERVER="http://localhost:8080/contacts"
BASICAUTH="--user `cat credentials.txt`"
# Test PUT to update a record
OLDUID="id1063441700038"

_xml() {
cat << EOF
<contact>
<displayName>New Contact</displayName>
<!--distinguishedName>uid=${NEWUID},uid=scott,ou=People,dc=geneticmail,dc=com</distinguishedName-->
<distinguishedName>uid=${NEWUID}</distinguishedName>
<firstName>New</firstName>
<lastName>Contact</lastName>
<nickname>NewGuy</nickname>
<primaryEmail>newguy@hotmail.com</primaryEmail>
<uid>${NEWUID}</uid>
</contact>
EOF
}

_updatexml() {
cat << EOF
<contact>
<displayName>Claire Chun</displayName>
<distinguishedName/>
<firstName>Claire</firstName>
<lastName>Chun</lastName>
<nickname>Updated Nickname</nickname>
<primaryEmail>clairechun@hotmail.com</primaryEmail>
<uid>id1063441700038</uid>
</contact>
EOF
}

_post() {
  NEWUID="id`./seconds`"
  echo $NEWUID > newuid.txt

  curl $BASICAUTH -X POST -HContent-type:application/xml --data "`_xml`" \
    ${SERVER}/${NEWUID}
}

_put() {
  curl $BASICAUTH -X PUT -HContent-type:application/xml --data "`_updatexml`" \
    ${SERVER}/${OLDUID}
}

_delete() {
  curl $BASICAUTH -X DELETE ${SERVER}/`cat newuid.txt`
}

while getopts "iud" option; do
  case "$option" in
  'i') _post; exit 0;;
  'u') _put; exit 0;;
  'd') _delete; exit 0 ;;
  esac
done
