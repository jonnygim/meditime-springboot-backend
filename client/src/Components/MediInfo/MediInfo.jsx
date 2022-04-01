import React, { useContext } from 'react';
import Button from './../../Commons/Button';
import MediCartContext from './../Store/MediCartContext';
import AddMediInfo from './AddMediInfo';
import classes from './MediInfo.module.css';
import MediInfoModal from './MediInfoModal';
import Medison from './Medison';

const MediInfo = (props) => {

  const cartContext = useContext(MediCartContext);
  
  // const [mediInfo, setMediInfo] = useState({//cartContext에서 받아온 약 정보});


  const infoTitle = (
    <ul className={classes.infotitle}>
      약 상세 정보
      <hr />
    </ul>
  )

  // 이건뭘넣어야하는거지 
  const mediCount = (

    <div className={classes.medicount}>
      <span>`이 약을 복용하고 있는 사람 : ${mediinfo.mediName}명`</span>
    </div>
  )

  // 모달 닫는 버튼
  const ModalButton = (
    <div className={classes.exitbutton}>
      <Button onClick={props.onClose}>x</Button>
    </div>
  )

  // 상세정보 불러오는 거
  const mediInfomation = (medison) => {
    <Medison
      key={props.id}
      id={props.id}
      name={props.name}
      entpItem={props.entpItem}
      efcItem={props.efcItem}
      methItem={props.methItem}
      warnItem={props.warnItem}
      atpnItem={props.atpnItem}
      intrItem={props.intrItem}
      seItem={props.seItem}
      depoItem={props.depoItem}
      itemImage={props.itemImage}
    // 구성요소 추가

    />

  }

  // 카드 담기 기능은 Medison에 붙여놓음 필요없음
  // 전체정보 추가해줘야 함 !  
  const mediinfo = {
    id: props.id,
    name: props.name,
    image: props.image,


  }

  cartContext.addItem(mediinfo);


  // 넣어줘야 함 
  const BASE_URL = '';

  const addMedisonToCartHandler = amount => {
    cartContext.addItem({
      id: props.id,
      name: props.name,
      amount: amount,
      image: props.image
    })
  }


  const MediInfoContent = (
    <>
      {/* 큰제목 */}
      {infoTitle}
      {/* 닫기버튼*/}
      {ModalButton}
      {/* 이 약을 복용하고 있는 사람 수*/}
      {mediCount}
      {/* 약 상세정보 */}
      {mediInfomation}
    </>
  )


  return (
      <>
      <MediInfoContent />
      <AddMediInfo onAddToCart={addMedisonToCartHandler} />
      </>

  )


}

export default MediInfo