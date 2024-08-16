import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import RecentCard from '../home/recent/RecentCard';
import TurfDetail from '../Detail/TurfDetail';

const SplitScreen = () => {
  const navigate = useNavigate();
  const { id, right_id } = useParams();
  const [rightId, setRightId] = useState(right_id || null);

  const handleCardSelect = (selectedId) => {
    setRightId(selectedId);
    navigate(`/compare/${id}/${selectedId}`);
  };

  return (
    <div style={{ display: 'flex', height: '100vh' }}>
      <div style={{ flex: 1, borderRight: '2px solid #ccc' }}>
        <TurfDetail id={id} />
      </div>
      <div style={{ flex: 1 }}>
        <RecentCard onCardSelect={handleCardSelect} />
      </div>
    </div>
  );
};

export default SplitScreen;
