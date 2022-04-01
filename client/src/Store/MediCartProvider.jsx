import React, { useState } from 'react'
import MediCartContext from './MediCartContext';

const MediCartProvider = (props) => {

    const [cartState, setCartState] = useState({
        items: [],
        totalAmount: 0
    });

    // 상세정보 모달에 약 상세정보를 추가하는 메서드
    const addOneMediToMediInfoHandler = (item) => {
        const updatedItem = [
            item
        ]

        setCartState({items: updatedItem, totalAmount: 0});
    }





    // cart에 medison 데이터를 추가하는 메서드
    const addItemToMediCartHandler= (item) => {

        const existingMediCartItemIndex = cartState.items.findIndex(
            (cartItem) => cartItem.name === item.name
        );

        const existingMediCartItem = cartState.items[existingMediCartItemIndex];

        let updatedItems;

        if(existingMediCartItem){
            const updatedItem = {
                    ...existingMediCartItem,
            }
            updatedItems = [...cartState.items];
            updatedItems[existingMediCartItemIndex] = updatedItem;
        } else {
            updatedItems = cartState.items.concat(item);
        }

        const updatedTotalAmount = cartState.totalAmount + (existingMediCartItem ? 0 : 1);
        setCartState({items: updatedItems, totalAmount: updatedTotalAmount})

    };



    // 하나씩 삭제하는 메서드
    const removeItemFromMediCartHandler = (id) => {

        const removeMediCartItem = cartState.items.filter((item)=> item.id !== id);

        setCartState(
            {items: removeMediCartItem, totalAmount: cartState.totalAmount-1}
        )};

    // 전체 삭제 메서드
    const removeAllItemFromMediCartHandler = () => {
        setCartState({items: [], totalAmount: 0})
    };

    // 텅 비었을 때 메소드(추가 예정)
    const EmptyMediCartHandler = () => {
        
    }

    const mediCartContext = {
        items: cartState.items,
        totalAmount: cartState.totalAmount,
        addItem: addItemToMediCartHandler,
        removeItem: removeItemFromMediCartHandler,
        removeAllItem: removeAllItemFromMediCartHandler,
        addOneMedi: addOneMediToMediInfoHandler,
    }


  return (
    <MediCartContext.Provider value={mediCartContext}>{props.children}</MediCartContext.Provider>
  )
}

export default MediCartProvider