import React, { useState } from "react";
import classes from "./MediCart.module.css";
import MediCartItem from "./MediCartItem";

const Cart = (props) => {
  const cartTitle = (
    <ul className={classes.carttitle}>
      약상자
      <hr />
    </ul>
  );

  const BASE_URL_FOR_GETCART = "";
  const [mediCartItems, setMediCartItems] = useState([]);

  //장바구니 아이템들을 가져오는 메서드
  const mediCartGetHandler = () => {
    console.log(isAuthorized);
    console.log(BASE_URL_FOR_GETCART + isAuthorized);

    const fetchMedisons = async () => {
      const response = await fetch(BASE_URL_FOR_GETCART + isAuthorized);
      console.log(response.ok);

      const responseData = await response.json();
      console.log(responseData);

      const mediCarItemsData = [];
      for (const key in responseData) {
        mediCarItemsData.push({
          id: key,
          itemName: responseData[key].itemName,
          entpName: responseData[key].entpName,
          efcItem: responseData[key].efcItem,
          methItem: responseData[key].methItem,
          warnItem: responseData[key].warnItem,
          atpnItem: responseData[key].atpnItem,
          intrItem: responseData[key].intrItem,
          seItem: responseData[key].seItem,
          depoItem: responseData[key].depoItem,
          itemImage: responseData[key].itemImage,
        });
      }
      setMediCartItems(mediCarItemsData);
    };
    fetchMedisons().catch((error) => console.log(error));
  };

  // 아이템 삭제 메서드
  const BASE_URL_FOR_DELETE = "";
  let isAuthorized = sessionStorage.getItem("isAuthorized");

  const deleteMediCartItem = () => {
    console.log(isAuthorized);
    console.log(BASE_URL_FOR_DELETE);

    const deleteMedicines = async () => {
      const response = await fetch(BASE_URL_FOR_DELETE + isAuthorized, {
        method: "DELETE",
      });
      console.log(response.ok);

      const responseData = await response.json();
      console.log(responseData);

      mediCartGetHandler();
    };
  };

  //아이템 배열
  const cartItems = mediCartItems.map((medison) => (
    <MediCartItem
      key={medison.id}
      id={medison.id}
      name={medison.name}
      image={medison.image}
      onRemoveInCart={deleteMediCartItem}
    />
  ));

  return (
    <>
      <button onClick={mediCartGetHandler}>reset</button>
      {cartTitle}
      {cartItems}
    </>
  );
};

export default Cart;
