#!/bin/bash

compose=/usr/local/bin/docker-compose

docker_file="${DOCKER_FILE_LOCATION}"

containers="${CONTAINERS}"
operation="${OPERATION}"

containerArray=(${containers//,/ })

echo "docker_opts: $opts"
echo "docker_file: $docker_file"
echo "containers: $containerArray"
echo "operation: $operation"

container_started='NO'

for container in "${containerArray[@]}"
do
    STATE=$(docker inspect --format="{{ .State.Running }}" ${container} 2> /dev/null)

    if [ "$STATE" != '' ]; then
        container_started='YES'
        break
    fi
done


if [ "$operation" == 'START' ]; then
	echo "START Containers $containerArray."

    if [ "$container_started" == 'YES' ]; then
        for c in "${containerArray[@]}"
        do
            echo "Stop exist container $c."
	        $compose -f ${c} stop && $compose -f ${c} rm -f
        done
    fi

    $compose -f ${docker_file} up -d

    sleep 5

    for c1 in "${containerArray[@]}"
    do
        STATE=$(docker inspect --format="{{ .State.Running }}" ${c1} 2> /dev/null)

        counter=0

        while ! $STATE ; do

            if [ "$counter" -ge 5 ]; then
                break
            fi
            sleep 3
            STATE=$(docker inspect --format="{{ .State.Running }}" ${c1} 2> /dev/null)
            counter=$(( $counter + 1 ))
        done

        if [ "$STATE" == "false" ]; then
          echo "CRITICAL - $c1 is not running."
          exit 2
        fi
    done


elif [ "$operation" == 'SHUTDOWN' ]; then
	echo "SHUTDOWN Containers $containerArray."

	for container in "${containerArray[@]}"
    do
	    docker stop ${container} && docker rm -f ${container}
    done

fi