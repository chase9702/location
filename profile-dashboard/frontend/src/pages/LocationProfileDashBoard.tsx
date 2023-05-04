import React from "react";
import {Typography, Button, Card, Empty, Spin} from 'antd';
import {useDispatch, useSelector} from 'react-redux';
import {setSelectMenu} from "@src/actions/MenuSelectAction";
const LocationProfileDashBoard = (): JSX.Element => {

    const dispatch = useDispatch();

    return (
        <div>
            <Button>
                dashboard버튼이다.
            </Button>
        </div>
    )
};

export const LocationProfileDashBoardElement = React.createElement(
    LocationProfileDashBoard,
);

export default LocationProfileDashBoardElement