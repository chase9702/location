import {KeplerGl} from 'kepler.gl';
import React, {useEffect, useState} from "react";


interface State {
}

interface Props {
    id: string,
    heightRatio: number,
}

const CustomKeplerMap = (props: Props): React.ReactElement => {

    const [height, setHeight] = useState(window.innerHeight);

    useEffect(() => {
        const handleResize = () => setHeight(window.innerHeight - 100);
        window.addEventListener('resize', handleResize);
        setHeight((window.innerHeight - 100) * (props.heightRatio * 0.01));
        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return (
        <div>
            <KeplerGl
                id={props.id}
                width={"100%"}
                height={height}
                mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
                // mapStyles={mapStyles2}
                // mapStylesReplaceDefault={true}
            />
            {/*<KeplerGl*/}
            {/*    mapboxApiAccessToken={token}*/}
            {/*    mapStyles={mapStyles2}*/}
            {/*    mapStylesReplaceDefault={true}*/}
            {/*    id="map"*/}
            {/*/>*/}
        </div>
    )
}

export default CustomKeplerMap;